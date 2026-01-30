package day1;
import com.microsoft.playwright.*;

public class ShadowDomEvaluateFixed {

  public static void main(String[] args) {
	  Page page = BrowserFactory.initBrowser("chrome", false, true);
      page.navigate("https://vrqaacademy.co.in/labs/shadow.html");

      // ================= BASIC =================
      page.evaluate("""
      () => {
        const host = document.querySelector("shadow-login");
        const root = host.shadowRoot;
        root.querySelector("#user").value = "Venkat";
        root.querySelector("#btn").click();
      }
      """);

      // ================= NESTED =================
      page.evaluate("""
      () => {
        const parent = document.querySelector("shadow-parent");
        const parentRoot = parent.shadowRoot;

        const child = parentRoot.querySelector("shadow-child");
        const childRoot = child.shadowRoot;

        childRoot.querySelector("#childInput").value = "Playwright";
        childRoot.querySelector("#childBtn").click();
      }
      """);

      // ================= IFRAME =================
      Frame iframe = page.frames()
          .stream()
          .filter(f -> f.url().contains("about:srcdoc"))
          .findFirst()
          .orElseThrow();

      iframe.evaluate("""
      () => {
        const host = document.querySelector("shadow-login");
        const root = host.shadowRoot;
        root.querySelector("#user").value = "InsideFrame";
        root.querySelector("#btn").click();
      }
      """);

      page.waitForTimeout(3000);
    }
}
