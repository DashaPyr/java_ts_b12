package dd.pyrkova.addressbook.tests;

import dd.pyrkova.addressbook.model.TestBase;
import dd.pyrkova.addressbook.model.UserData;
import org.testng.annotations.Test;

public class DeleteUserTests extends TestBase {

  @Test
  public void testDeleteUser() throws Exception {
    app.getNavigationHelper().returnToHomePage();
    if (! app.getUserHelper().isThereAUser()){
      app.getUserHelper().createUser(new UserData("Daria", "Vladimirovna", "Pyrkova", "dd", "U", "Dolgoprudny", "d@u.ru", "d@g.com", "999", "777", "888", "1", "January", "1990", "test1"), true);
      app.getNavigationHelper().returnToHomePage();
    }
    app.getUserHelper().selectUser();
    app.getUserHelper().deleteSelectedUser();
    app.getCloseAlertHelper().closeAlertDialog();
    app.getNavigationHelper().returnToHomePage();
    app.getSessionHelper().logout();
  }

}
