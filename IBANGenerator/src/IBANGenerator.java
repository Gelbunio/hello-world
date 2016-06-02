

public class IBANGenerator {

	private int getDigit() {
		return (int) Math.floor(Math.random() * 10);
	}

	public String calcIBAN(String bankCode, String company, String system, String accountNumber) {
		
		String r = "";
		int controlNumber = 0;
		int bankCodeLength = bankCode.length();
		int companyLength = company.length();
		int systemLength = system.length();
		int accountNumberLength = accountNumber.length();
		
		if (bankCode == null || bankCode == "")
		{
		
			int cyfry[] = { getDigit(), getDigit(),getDigit(), getDigit(),getDigit(), getDigit(),getDigit(), getDigit()};
			
			for (int i = 0; i < cyfry.length; i++)
				bankCode += cyfry[i];		
	
		}	
		
		if (company == null || company == "")
		{
		
			int cyfry[] = { getDigit(), getDigit(),getDigit(), getDigit()};
			
			for (int i = 0; i < cyfry.length; i++)
				company += cyfry[i];		
	
		}	
		
		if (system == null || system == "")
		{
		
			int cyfry[] = { getDigit(), getDigit()};
			
			for (int i = 0; i < cyfry.length; i++)
				system += cyfry[i];		
	
		}	
				
		if (bankCode.length() < 8 && bankCode != "")
		{
			for (int i = 0; i < 8 - bankCodeLength; i++)
			{
				bankCode = "0" + bankCode;
			}
		}
		
		if (company.length() < 4 && company != "")
		{
			for (int i = 0; i < 4 - companyLength; i++)
			{
				company = "0" + company;
			}
		}
		
		if (system.length() < 2 && system != "")
		{
			for (int i = 0; i < 2 - systemLength; i++)
			{
				system = "0" + system;
			}
		}
				
		if (accountNumber.length() < 10 && accountNumber != "")
		{
			for (int i = 0; i < 10 - accountNumberLength; i++)
			{
				accountNumber = "0" + accountNumber;
			}
		}
		
		r += bankCode;
		r += company;
		r += system;

		
		if (accountNumber == null || accountNumber == "")
		{
		
			int cyfry[] = { getDigit(), getDigit(), getDigit(), getDigit(), getDigit(), getDigit(), getDigit(), getDigit(), getDigit(), getDigit()};
			
			for (int i = 0; i < cyfry.length; i++)
				r += cyfry[i];		
		
			String rd = "";
			rd = r + "252100";

			for (char c : rd.toCharArray())
			{
				controlNumber = (10 * controlNumber + Integer.parseInt(String.valueOf(c))) % 97;
			}
		
			controlNumber = 98 - controlNumber;
		
			
			
			r = controlNumber + r;
			
			if (r.length() != 26 )
			{
				r = 0 + r;
			}
		}		
		
		else
		{
			
			r += accountNumber;
			String rd = "";
			rd = r + "252100";

			for (char c : rd.toCharArray())
			{
				controlNumber = (10 * controlNumber + Integer.parseInt(String.valueOf(c))) % 97;
			}
		
			controlNumber = 98 - controlNumber;
		
			r = controlNumber + r;
			if (r.length() != 26 )
			{
				r = 0 + r;
			}
		}
	

			return r;
	}

}
