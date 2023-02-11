package testcases;

import org.testng.annotations.Test;

import pages.BestBuyAuto;

public class TestCase1 extends BestBuyAuto {
	@Test

	public void test() throws Exception {

		BestBuyAuto sp = new BestBuyAuto();
		sp.buttonclick();
		sp.createAccount("Tamsil", "Ahmed", "tamsilahmedbe@gmail.com", "One+Nine=Ten", "7094188414");

		sp.emailcheck();

		sp.signinclick();

		sp.signinType("tamsilahmedbe@gmail.com", "One+Nine=Ten");

		sp.hardrefresh();

		sp.sikulisignin();
		
		sp.Welcomepage();

		sp.ShopByDepartment();

		sp.Continue();

		sp.ShopByBrands();

		sp.Continue();

		sp.cartclick();

		sp.cartdetails("4410311052186498", "776");

		sp.paymentdetails("Tamsil", "Ahmed", "3920 Star Trek Drive", "Panama City", "32405");
	}

}
