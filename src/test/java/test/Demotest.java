package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import base.Demobase;

public class Demotest extends Demobase{
	@Test(priority=1)
	public void login() {
		dp.loginbutton();
		dp.loginpath("gibina","ayana@123");
	}
	@Test(priority=2)
	public void home() {
		dh.homepage();
	}
	@Test(priority=3)
	public void phonepage() {
		Assert.assertTrue(dh.phonetext(), "phone is not displayed");
		
	}
	@Test(priority=4)
	public void alllinks() {
		dh.alllinks();
	}
	@Test(priority=5)
	public void product() {
		dh.product();
	}
	@Test(priority=6)
	public void cart() {
		Assert.assertTrue(dc.cartbutton(),"cartbutton is not displayed");
		dc.cartclick();
	}
	@Test(priority=7)
	public void carticon() {
		dc.cart();
	}
	@Test(priority=8)
	public void placeorder() {
		
		dc.placorder();
	}
	@Test(priority=9)
	public void fill() {
		dc.fillform("gibina", "india", "aluva", "123456", "10", "2003");
		dc.purchaseclick();
	}
	@Test(priority = 10)
	public void confirmation() {
		Assert.assertTrue(dc.thankyoudisplayed(), "purchase confirmation not displayed");
		dc.okbutton();
	}
	@Test(priority=11)
	public void close() {
		dc.closebutton();
	}
		@Test(priority = 12)
		public void newtab() {
			dc.opennewtab();
		}
		@Test(priority = 13)
		public void addAllLaptops() {
		    dn.addAllLaptops();
		}
		@Test(priority=14)
		public void hometab() {
			dn.home();
		}
		@Test(priority=15)
		public void next() {
			dn.nexttab();
		}
		@Test(priority=16)
		public void monitor() {
			dn.monitortab();
			
		}
		@Test(priority=17)
		public void previous() {
			dn.previousbutton();
			
	}
		@Test(priority=18)
		public void contact() {
			dct.contacttab();
		}
		@Test(priority=19)
		public void fillform() throws IOException {
		dct.fill("gibinabiju2@gmail.com", "gibina","hi");
		dct.sendmessage();
		}
		@Test(priority=20)
		public void about() {
			da.aboutus();
			
		}
		@Test(priority=21)
		public void start() {
			da.start();
			da.pause();
			da.soundbutton();
			da.picture();
		}
		@Test(priority=22)
		public void fullscreen() {
			da.fullscreenbutton();
			da.nonfullscreenbutton();
			da.closebutton();
		}
		@Test(priority=23)
		public void logout() {
			da.logoutbutton();
		}
		
}

