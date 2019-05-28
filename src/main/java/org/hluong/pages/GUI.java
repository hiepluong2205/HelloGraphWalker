package org.hluong.pages;

import org.hluong.utils.Helper;

public class GUI {

  public static String urlPageHome = "http://the-internet.herokuapp.com/";
//  https://saucelabs-sample-test-frameworks.github.io/training-test-page

  private static PageHome pageHome = new PageHome();

  public static PageHome getPageHome() {
    return pageHome;
  }

  public static void goToPageHome() {
    Helper.getDriver().get(urlPageHome);
  }
}
