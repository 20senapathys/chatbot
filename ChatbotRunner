import java.util.Scanner;
public class ChatbotRunner
{
	public static void main(String[] args)
	{
		Chatbot chatty = new Chatbot();
		
		System.out.println (chatty.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		System.out.println ("That's awesome! It's very nice to meet you. My name's Chatty! What do you like to do, or do you have family?");
			statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (chatty.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
