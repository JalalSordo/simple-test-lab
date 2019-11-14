package com.everis.example.service;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;
import org.junit.rules.Verifier;

public class MiscTests {

	@Test(expected = NullPointerException.class)
	public void testSortClassNPE() {
		int[] numbers = null;
		Arrays.sort(numbers);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testTempFolder() {
		try {
			File tempFile = tempFolder.newFile();
			System.out.println(tempFile.getAbsolutePath());
			assertNotNull(tempFile);

		} catch (IOException e) {
			fail("Shouldn't throw exception");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void givenIllegalArgument_whenExceptionThrown_MessageAndCauseMatches() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectCause(isA(NullPointerException.class));
		thrown.expectMessage("This is illegal");

		throw new IllegalArgumentException("This is illegal", new NullPointerException());
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
	@Rule
	public TestName name = new TestName();

	@Test
	public void givenAddition_whenPrintingTestName_thenTestNameIsDisplayed() {
		System.out.println("Executing: " + name.getMethodName());
		assertEquals("givenAddition_whenPrintingTestName_thenTestNameIsDisplayed", name.getMethodName());
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Test
	public void givenLongRunningTest_whenTimout_thenTestFails() throws InterruptedException {
		TimeUnit.SECONDS.sleep(4);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
	private List messageLog = new ArrayList();

	@Rule
	public Verifier verifier = new Verifier() {
		@Override
		public void verify() {
			assertTrue("Message Log is not Empty!", messageLog.isEmpty());
		}
	};

	@Test
	public void givenNewMessage_whenVerified_thenMessageLogNotEmpty() {

		// messageLog.add("There is a new message!");
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
	@ClassRule
	public static final ExternalResource externalResource = new ExternalResource() {
		//a sperate class for the impl is better
		//@Rule
	    //public final JettyServerResource server = new JettyServerResource();
		
		@Override
		protected void before() throws Throwable {
			 System.out.println("Start Server...");
		};

		@Override
		protected void after() {
			 System.out.println("Stop Server...");
		};
	};
}
