package jdbc_library_manegment_system;

import java.util.Scanner;

public class LibraryMain {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<<<<<<<<<<<<*****Welcome*****>>>>>>>>>>>>  \n 1.Register \n 2.LogIn \n 3.Exit ");

		System.out.println("Enter your choice ");
		int choice = scanner.nextInt();
		
		LibraryCRUD crud = new LibraryCRUD();
		
					switch (choice) 
					{
						case 1:
						{
							System.out.println("Enter the id");
							int  id =scanner.nextInt();
							System.out.println("Enter the name");
							String name =scanner.next();
							System.out.println("Enter the email");
							String email=scanner.next();
							System.out.println("Enter the phoneNumber");
							long phone =scanner.nextLong();
							System.out.println("Enter the Password");
							String password =scanner.next();
							
							Library library = new Library();
							
							library.setId(id);
							library.setName(name);
							library.setEmail(email);
							library.setPhone(phone);
							library.setPassword(password);
							
							int count = crud.registerPerson(library);
							if (count != 0)
							{
								System.out.println("Registration complited");
							}
							else
							{
								System.out.println("Registration failed");

							}
					
						}
							break;
						case 2:
						{
							System.out.println("Enter the mail id");
							String email = scanner.next();
							System.out.println("Enter the Password");
							String password =scanner.next();
							String dbpass = crud.logIn(email);
							
							if (dbpass != null ) 
							{
								if (password.equals(dbpass)) 
								{
									System.out.println("LogIn successfully");
									
									System.out.println("Select below opption  \n1.addBook \n2.searchBookById \n3.searchBookByName \n4.searchBookByOuther ");
									
									switch (scanner.nextInt()) 
									{
									case 1 :
									{
										System.out.println("Enter the book id");
										int bId =scanner.nextInt();
										System.out.println("Enter the book name");
										String bName =scanner.next();
										System.out.println("Enter book outher");
										String outher =scanner.next();
										System.out.println("Enter the book type");
										String tyoe = scanner.next();
										
										 Library library = new Library();
										 
										 library.setbId(bId);
										 library.setbName(bName);
										 library.setOuther(outher);
										 library.setType(tyoe);
										 
										 int count = crud.addBook(library);
											if (count != 0)
											{
												System.out.println("book added");
											}
											else
											{
												System.out.println("book not added");

											}
									
										
											}
												break;
		
											default:
												break;
											}
										}
										else
										{
											System.out.println("LogIn not successfull");
		
										}
									}
									else
									{
										System.out.println("person not register");
									}
								}
								break;
						
								case 3 :
								{
									System.out.println("Exit");
									break;
								}
								
								
							}
			}

}
