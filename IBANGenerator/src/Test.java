
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class Test {

	static String bankCode;
	static String clientNumber;
	static String systemCode;
	static String accountNumber;
	static IBANGenerator ibg;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ibg = new IBANGenerator();
		Display display = new Display();
		Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setLayout(new GridLayout(4, true));
	    Image small = new Image(display,"icon.png");
	    
	    shell.setImage(small);    

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;

		GridData gridDataFill = new GridData();
		gridDataFill.horizontalAlignment = GridData.FILL;

		final Label bankCodeL = new Label(shell, SWT.CENTER);
		final Label clientNumberL = new Label(shell, SWT.CENTER);
		final Label systemCodeL = new Label(shell, SWT.CENTER);
		final Label accountNumberL = new Label(shell, SWT.CENTER);
		bankCodeL.setText("Kod banku");
		clientNumberL.setText("Numer klienta");
		systemCodeL.setText("Kod systemu");
		accountNumberL.setText("Numer konta");

		final Text bankCodeIns = new Text(shell, SWT.BORDER);
		final Text clientNumberIns = new Text(shell, SWT.BORDER);
		final Text systemCodeIns = new Text(shell, SWT.BORDER);
		final Text accountNumberIns = new Text(shell, SWT.BORDER);
		bankCodeIns.setText("12345678");
		bankCodeIns.setTextLimit(8);
		bankCodeIns.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				event.doit = false;

				char myChar = event.character;
				((Text) event.widget).getText();

				if (Character.isDigit(myChar))
					event.doit = true;

				if (myChar == '\b') {
					event.doit = true;

				}
			}

		});

		clientNumberIns.setText("1234");
		clientNumberIns.setTextLimit(4);
		clientNumberIns.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				event.doit = false;

				char myChar = event.character;
				((Text) event.widget).getText();

				if (Character.isDigit(myChar))
					event.doit = true;

				if (myChar == '\b') {
					event.doit = true;

				}
			}

		});

		systemCodeIns.setText("12");
		systemCodeIns.setTextLimit(2);
		systemCodeIns.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				event.doit = false;

				char myChar = event.character;
				((Text) event.widget).getText();

				if (Character.isDigit(myChar))
					event.doit = true;

				if (myChar == '\b') {
					event.doit = true;

				}
			}

		});

		accountNumberIns.setText("1234567890");
		accountNumberIns.setTextLimit(10);
		accountNumberIns.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				event.doit = false;

				char myChar = event.character;
				((Text) event.widget).getText();

				if (Character.isDigit(myChar))
					event.doit = true;

				if (myChar == '\b') {
					event.doit = true;

				}
			}

		});


		bankCodeIns.setLayoutData(gridDataFill);
		clientNumberIns.setLayoutData(gridDataFill);
		systemCodeIns.setLayoutData(gridDataFill);
		accountNumberIns.setLayoutData(gridDataFill);

		final Text output = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		output.setLayoutData(gridData);
		output.setText("00000000000000000000000000");
		Button button = new Button(shell, SWT.PUSH);
		button.setLayoutData(gridData);
		button.setText("Generuj");

		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {

				bankCode = bankCodeIns.getText();
				clientNumber = clientNumberIns.getText();
				systemCode = systemCodeIns.getText();
				accountNumber = accountNumberIns.getText();
				output.setText(ibg.calcIBAN(bankCode, clientNumber, systemCode, accountNumber));

			}

			public void widgetDefaultSelected(SelectionEvent event) {

				bankCode = bankCodeIns.getText();
				clientNumber = clientNumberIns.getText();
				systemCode = systemCodeIns.getText();
				accountNumber = accountNumberIns.getText();
				output.setText(ibg.calcIBAN(bankCode, clientNumber, systemCode, accountNumber));

			}
		});

		shell.setSize(360, 110);
		shell.setText("Generator IBAN");

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

		System.out.println();

	}

}
