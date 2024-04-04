package manytomany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import manytomany.dao.LangaugeDao;
import manytomany.dao.PersonDao;
import manytomany.dto.Langauge;
import manytomany.dto.Person;

public class Main {
	public static void main(String[] args) {
		PersonDao dao = new PersonDao();
		LangaugeDao langaugeDao = new LangaugeDao();
		Scanner scanner = new Scanner(System.in);
		outer:
		for (;;) {
			System.out.print("Enter the option: \n1.Langauge Operation \n2.Person Operation \n3.Exit");
			switch (scanner.nextInt()) {
			case 1: {
				inner1:
				for(;;) {
					System.out.println(
							"Enter the option \n1.AddLangauge \n2.GetLangaugeById \n3.GetAllLangugePresent \n4.UpdateLanguage \n5.DeleteLangauge \n6.Exit");
					switch (scanner.nextInt()) {
					case 1: {
						System.out.println("No of langauge you want to add");
						int no = scanner.nextInt();
						Langauge langauge = new Langauge();
						for (int i = 1; i <= no; i++) {
							System.out.println("Enter the Langauge Id:");
							langauge.setId(scanner.nextInt());
							System.out.println("Enter the Langauge name:");
							langauge.setName(scanner.next());
							System.out.println("Enter the Langauge origin:");
							langauge.setOrigin(scanner.next());
						}
						langaugeDao.saveLangauge(langauge);
					}

						break;
					case 2: {
						System.out.println("Enter the Langauge Id:");
						langaugeDao.fetchLangauge(scanner.nextInt());
					}
						break;
					case 3: {

						langaugeDao.fetchAllLangauge();
					}
						break;

					case 4: {
						System.out.println("Enter the Langauge Id:");
						int id = scanner.nextInt();
						Langauge langauge = new Langauge();
						System.out.println("Enter the Langauge Id:");
						langauge.setId(scanner.nextInt());
						System.out.println("Enter the Langauge name:");
						langauge.setName(scanner.next());
						System.out.println("Enter the Langauge origin:");
						langauge.setOrigin(scanner.next());
						langaugeDao.UpdateLangauge(id, langauge);

					}
						break;
					case 5: {
						System.out.println("Enter the Langauge Id:");
						langaugeDao.deleteLangauge(scanner.nextInt());
					}
						break;
					case 6:{
						continue outer ;
					}

					default:
						 System.out.println("plese enter the correct option");
						break;
					}
				}
				}
				
			case 2: {
				inner2:
				for(;;) {
					System.out.println(
							"Enter the option \n1.SavePerson \n2.AddLangaugeToPerson \n3.updatePerson \n4.deletePerson \n5.GetPersonByID \n6.GetAllPerson \n7.Exit");
					switch (scanner.nextInt()) {
					case 1: {
						Person person = new Person();
						System.out.println("Enter the Person Id:");
						person.setId(scanner.nextInt());
						System.out.println("Enter the Person name:");
						person.setName(scanner.next());
						System.out.println("Enter the Person address:");
						person.setAddress(scanner.next());
						System.out.println("Enter the Person phoneNo:");
						person.setPhone(scanner.nextLong());

						List<Langauge> list = new ArrayList<Langauge>();
						System.out.println("Enter the no of language you Know  ");
						int no = scanner.nextInt();
						for (int i = 1; i <= no; i++) {
							Langauge langauge = new Langauge();
							System.out.println("Enter the Langauge Id:");
							langauge.setId(scanner.nextInt());
							System.out.println("Enter the Langauge name:");
							langauge.setName(scanner.next());
							System.out.println("Enter the Langauge origin:");
							langauge.setOrigin(scanner.next());
							list.add(langauge);
						}
						person.setList(list);
						dao.savePerson(person);

					}

						break;
					case 2: {
						System.out.println("Enter the Person Id:");
						int id = scanner.nextInt();
						langaugeDao.fetchAllLangauge();
						System.out.println("Enter the no of language you Know in given data ");
						int no=scanner.nextInt();
						List<Integer> list = new ArrayList<Integer>();
						for (int i = 1; i <= no; i++) {
							System.out.print("Enter the language id");
							list.add(scanner.nextInt());
						}
						dao.addLangaugePerson(id, list);

					}
						break;
					case 3: {
						System.out.println("Enter the Person Id:");
						int id = scanner.nextInt();
						Person person = new Person();
						System.out.println("Enter the Person Id:");
						person.setId(scanner.nextInt());
						System.out.println("Enter the Person name:");
						person.setName(scanner.next());
						System.out.println("Enter the Person address:");
						person.setAddress(scanner.next());
						System.out.println("Enter the Person phoneNo:");
						person.setPhone(scanner.nextLong());
						dao.updatePerson(id, person);

					}
						break;
					case 4: {
						System.out.println("Enter the Person Id:");
						int id = scanner.nextInt();
						dao.deletePerson(id);
					}
						break;
					case 5: {
						System.out.println("Enter the Person Id:");
						int id = scanner.nextInt();
						dao.getPersonById(id);
					}
						break;
					case 6: {
						dao.fetchAllPerson();
					}
						break;
					case 7:{
						continue outer;
					}
					default:
		             System.out.println("plese enter the correct option");
						break;
					}

					
				}
			}
				
			case 3:{
				System.exit(0);
			}
			default:
				 System.out.println("please enter the correct option");
				 break;
			}
		}
	}

}
