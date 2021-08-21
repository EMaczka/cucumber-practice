package org;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("Konto z saldem {int} zl")
    public void kontoZSaldemZl(int arg0) {
        System.out.println();
    }

    @When("Uzytkownik probuje wyplacic {int} zl")
    public void uzytkownikProbujeWyplacicZl(int arg0) {
    }

    @Then("Saldo nie zmienia sie i wynosi {int} zl")
    public void saldoNieZmieniaSieIWynosiZl(int arg0) {
    }
}
