package dd.pyrkova.addressbook.appmanager;

import dd.pyrkova.addressbook.model.Groups;
import dd.pyrkova.addressbook.model.UserData;
import dd.pyrkova.addressbook.model.Users;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserHelper extends HelperBase {

  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitUserCreation() {
    click(By.xpath("//input[@name='submit']"));
  }

  public void fillInUserData(UserData userData, boolean creation ) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("middlename"), userData.getMiddlename());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("nickname"), userData.getNickname());
    type(By.name("company"), userData.getCompany());
    type(By.name("address"), userData.getAddress());
    type(By.name("email"), userData.getEmailone());
    type(By.name("email2"), userData.getEmailtwo());
    type(By.name("home"), userData.getPhonehome());
    type(By.name("mobile"), userData.getPhonemobile());
    type(By.name("work"), userData.getPhonework());
    select(By.name("bday"), userData.getBirthday());
    select(By.name("bmonth"), userData.getBirthmonth());
    type(By.name("byear"), userData.getBirthyear());
    attach(By.name("photo"), userData.getPhoto());

    if (creation) {
      if (userData.getGroups().size() > 0) {
        Assert.assertTrue(userData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isGroupElementPresent(By.name("new_group")));
    }
  }

  public void gotoNewUserPage() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedUser() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void initUserModificationById(int id) {
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//    WebElement row = checkbox.findElement(By.xpath("./../.."));
//    List<WebElement> cells = row.findElements(By.tagName("td"));
//    cells.get(7).findElement(By.tagName("a")).click();
  }

  public void submitUserModification() {
    click(By.xpath("//input[@name='update']"));
  }

  public void selectUserById(int id) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
  }

  public boolean isThereAUser() {
    return isUserElementPresent(By.name("selected[]"));
  }

  public void create(UserData user, boolean b) {
    gotoNewUserPage();
    fillInUserData(user, b);
    submitUserCreation();
    userCache = null;
  }

  public void modify(UserData user) {
    initUserModificationById(user.getId());
    fillInUserData(user, false);
    submitUserModification();
    userCache = null;
  }

  public void delete(UserData user) {
    selectUserById(user.getId());
    deleteSelectedUser();
    userCache = null;
  }

  public int userCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void addUserToGroup() {
    wd.findElement(By.name("add")).click();
  }

  public void selectGroupStatic(String groupName, UserData user) {
    selectUserById(user.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(groupName);
    addUserToGroup();
  }

  public void selectGroup(UserData user, boolean select){
    selectUserById(user.getId());
    if (select){
      if (user.getGroups().size() > 0) {
        Assert.assertTrue(user.getGroups().size() == 1);
        new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(user.getGroups().iterator().next().getName());
      }
    }
    addUserToGroup();
  }


  private Users userCache = null;

  public Users allUser() {
    if (userCache != null){
      return new Users(userCache);
    }
    userCache = new Users();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lname = cells.get(1).getText();
      String fname = cells.get(2).getText();
      String addr = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      userCache.add(new UserData().withId(id).withFirstname(fname).withLastname(lname).withAddress(addr)
              .withAllEmails(allEmails)
              .withAllPhones(allPhones));
    }
    return new Users(userCache);
  }

  public UserData infoFromUserForm(UserData user) {
    initUserModificationById(user.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    wd.navigate().back();
    return new UserData().withId(user.getId()).withFirstname(firstname).withLastname(lastname)
            .withEmailone(email).withEmailtwo(email2)
            .withPhonehome(home).withPhonemobile(mobile).withPhonework(work);
  }
}