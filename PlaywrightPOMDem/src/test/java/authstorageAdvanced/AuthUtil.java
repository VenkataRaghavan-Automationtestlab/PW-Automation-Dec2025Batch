package authstorageAdvanced;

import com.microsoft.playwright.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class AuthUtil {

    private static final String AUTH_DIR = "src/test/resources/authstorageAdvanced/";
    private static final Duration MAX_AUTH_AGE = Duration.ofHours(6);

    // 👥 User credentials
    private static final Map<String, UserCred> USERS = Map.of(
            "admin", new UserCred("admin", "admin123"),
            "user", new UserCred("venkat", "venkat123")
    );

    /**
     * Main entry point for BaseTest
     */
    public static BrowserContext getAuthenticatedContext(Browser browser, String role) {

        ensureAuthDir();

        Path authFile = Paths.get(AUTH_DIR + role + ".json");
        File file = authFile.toFile();

        // 1️⃣ If missing or expired → regenerate
        if (!file.exists() || isExpired(file)) {
            System.out.println("🔐 Creating new session for: " + role);
            generateAuth(browser, role, authFile);
        }

        // 2️⃣ Create context using storage state
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setStorageStatePath(authFile)
        );

        // 3️⃣ Validate session is still alive
        if (!isSessionValid(context)) {
            System.out.println("♻️ Session invalid for " + role + ". Re-generating...");
            context.close();

            generateAuth(browser, role, authFile);

            context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setStorageStatePath(authFile)
            );
        }

        System.out.println("✅ Using session for role: " + role);
        return context;
    }

    /**
     * Force regeneration (used by BaseTest auto-heal)
     */
    public static void forceRegenerate(Browser browser, String role) {
        ensureAuthDir();
        Path authFile = Paths.get(AUTH_DIR + role + ".json");
        generateAuth(browser, role, authFile);
    }

    /**
     * Check if redirected to login page
     */
    private static boolean isSessionValid(BrowserContext context) {
        Page page = context.newPage();
        page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/inventory.html");

        boolean isLogin = page.url().contains("index.html");

        page.close();
        return !isLogin;
    }

    /**
     * Generate session file for user
     */
    private static void generateAuth(Browser browser, String role, Path authFile) {

        UserCred cred = USERS.get(role);
        if (cred == null)
            throw new RuntimeException("❌ No credentials defined for role: " + role);

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        System.out.println("🔐 Logging in as: " + role);

        // 🔐 Login flow
        page.navigate("https://swautomationtester-dot.github.io/IshaDemoV1/index.html");

        page.fill("#username", cred.username);
        page.fill("#password", cred.password);
        page.click("button[type='submit']");

        page.waitForURL("**/inventory.html");

        // 💾 Save session
        context.storageState(new BrowserContext.StorageStateOptions()
                .setPath(authFile));

        context.close();

        System.out.println("💾 Session saved: " + authFile);
    }

    /**
     * Check age-based expiry
     */
    private static boolean isExpired(File file) {
        Instant lastModified = Instant.ofEpochMilli(file.lastModified());
        Duration age = Duration.between(lastModified, Instant.now());

        System.out.println("🕒 Auth age: " + age.toMinutes() + " minutes");

        return age.compareTo(MAX_AUTH_AGE) > 0;
    }

    /**
     * Ensure authstorageAdvanced directory exists
     */
    private static void ensureAuthDir() {
        try {
            Files.createDirectories(Paths.get(AUTH_DIR));
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to create authstorageAdvanced directory: " + AUTH_DIR, e);
        }
    }

    /**
     * Simple credential holder
     */
    private static class UserCred {
        String username;
        String password;

        UserCred(String u, String p) {
            username = u;
            password = p;
        }
    }
}
