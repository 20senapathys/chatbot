import java.util.Random;
public class Chatbot
{
		public String getGreeting()
	{
		return "Hey, there! Tell me a little about yourself. What's your name?";
	}
		public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Won't you please speak?";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why not? You're making me feel bad!";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
        || findKeyword(statement, "mom") >= 0
        || findKeyword(statement, "dad") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Sounds cool! Do you have any pets?";
		}

    else if (findKeyword(statement, "dog") >= 0
				|| findKeyword(statement, "cat") >= 0
        || findKeyword(statement, "iguana") >= 0
        || findKeyword(statement, "turtle") >= 0
				|| findKeyword(statement, "fish") >= 0
				|| findKeyword(statement, "pet") >= 0)
		{
			response = "Nice! I would like a pet, too, but I have no way to feed it!";

    }

		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

    else if (findKeyword(statement, "I like to", 0) >= 0)
    {
      response = transformILikeStatement(statement);
    }
		else
		{
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				psn = findKeyword(statement, "i", 0);

				if (psn >= 0
						&& findKeyword(statement, "you", psn) >= 0)
				{
					response = transformIYouStatement(statement);
				}
				else
				{
					response = getRandomResponse();
				}
			}
		}
		return response;
	}
	private String transformILikeStatement(String statement)
	{
    statement = statement.trim();
    String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I like to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you like to " + restOfStatement + " ?";
  }
		private String transformIWantToStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + " ?";
	}

	private String transformIWantStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you be happy if you had " + restOfStatement + "?";
	}
	
		private String transformYouMeStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
		private String transformIYouStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Do you really " + restOfStatement + " me?";
	}
	

	
	
		private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		while (psn >= 0) 
		{
			String before = " ", after = " "; 
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
			
		}
		
		return -1;
	}
		private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


		private String getRandomResponse ()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}
	
	private String [] randomResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Sounds awesome!",
			"Cool!",
			"Okay.",
			"Can you repharase that?"

	};
	
}
