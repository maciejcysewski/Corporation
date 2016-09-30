package pl.jcode.corporation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import pl.jcode.corporation.domain.Employee;
import pl.jcode.corporation.domain.Menu;

public class App {

	static List<Employee> employees;
	static List<Employee> deletedEmployees;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Menu menu = new Menu();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int option;
		boolean flag = true;

		employees = new ArrayList<>();
		deletedEmployees = new ArrayList<>();

		while (flag) {
			// Menu
			menu.mainManu();
			try {
				option = Integer.parseInt(reader.readLine());
	
				switch (option) {
				case 1: // list
					showEmployees();
					break;
				case 2: // add
					addEmployees();
					break;
				case 3: // delete
					deleteEmployee();
					break;
				case 4: // edit
					editEmployee();
					break;
				case 5: // deleted employees
					showDelEmployees();
					break;
				case 6: // exit
					System.out.println('\n' + "ZAKOÑCZONO");
					flag = false;
					break;
				default:
					System.out.println("Proszê wybraæ jedn¹ ze wskazanych opcji!" + '\n');
				}
			} catch (NumberFormatException e) {
				System.out.println("Proszê wybraæ jedn¹ ze wskazanych opcji!" + '\n');
			}
		}
	}

	public static void showEmployees() throws IOException {
		if (employees.size() > 0) {
			System.out.println("---------------------");
			for (int i = 0; i < employees.size(); i++) {
				showEmployee(i);
			}
			System.out.println("---------------------");
		} else {
			System.out.println('\n' + "Brak wyników.");
		}
	}

	public static void showDelEmployees() throws IOException {
		if (deletedEmployees.size() > 0) {
			System.out.println("---------------------");
			for (int i = 0; i < deletedEmployees.size(); i++) {
				showDelmployee(i);
			}
			System.out.println("---------------------");
		} else {
			System.out.println('\n' + "Brak wyników.");
		}
	}

	public static void showEmployee(int id) {
		System.out.println("." + (id + 1) + ".");
		System.out.println(" - Imie: " + employees.get(id).getFirstName());
		System.out.println(" - Nazwisko: " + employees.get(id).getLastName());
		System.out.println(" - Login: " + employees.get(id).getLogin());
		System.out.println(" - Email: " + employees.get(id).getEmail());
		System.out.println(" - Nr tel.: " + employees.get(id).getPhoneNumber());
		System.out.println(" - Stanowisko: " + employees.get(id).getPosition());
	}

	public static void showDelmployee(int id) {
		System.out.println("." + (id + 1) + ".");
		System.out.println(" - Imie: " + deletedEmployees.get(id).getFirstName());
		System.out.println(" - Nazwisko: " + deletedEmployees.get(id).getLastName());
		System.out.println(" - Login: " + deletedEmployees.get(id).getLogin());
		System.out.println(" - Email: " + deletedEmployees.get(id).getEmail());
		System.out.println(" - Nr tel.: " + deletedEmployees.get(id).getPhoneNumber());
		System.out.println(" - Stanowisko: " + deletedEmployees.get(id).getPosition());
	}

	public static void deleteEmployee() throws IOException {
		System.out.println();
		System.out.print("Podaj LOGIN pracownika, którego chcesz usun¹æ: ");
		String login = reader.readLine();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getLogin().equals(login)) {
				showEmployee(i);
				menu.deleteMenu();
				String option = reader.readLine();
				switch (option) {
				case "T":
				case "t":
					System.out.println("Pracownik " + employees.get(i).getFirstName() + " "
							+ employees.get(i).getLastName() + " zosta³ usuniêty.");
					deletedEmployees.add(employees.get(i));
					employees.remove(i);
					break;
				case "N":
				case "n":
					System.out.println("Operacja anulowana.");
					break;
				default:
					System.out.println("Nieprawid³owa wartoœæ! Operacja anulowana.");
				}
				break;
			} else {
				System.out.println("Brak pracownika o podanym loginie!");
			}
		}
	}

	public static void editEmployee() throws IOException {
		String data;
		System.out.println();
		System.out.print("Podaj LOGIN pracownika, którego dane chcesz edytowaæ: ");
		String login = reader.readLine();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getLogin().equals(login)) {
				showEmployee(i);
				menu.editMenu();
				String option = reader.readLine();
				switch (option) {
				case "I":
				case "i":
					System.out.println("Nowa wartoœæ: ");
					data = reader.readLine();
					employees.get(i).setFirstName(data);
					System.out.println("Dane zaktualizowane.");
					showEmployee(i);
					break;
				case "N":
				case "n":
					System.out.println("Nowa wartoœæ: ");
					data = reader.readLine();
					employees.get(i).setLastName(data);
					System.out.println("Dane zaktualizowane.");
					showEmployee(i);
					break;
				case "L":
				case "l":
					System.out.println("Nowa wartoœæ: ");
					data = reader.readLine();
					employees.get(i).setLogin(data);
					System.out.println("Dane zaktualizowane.");
					showEmployee(i);
					break;
				case "E":
				case "e":
					System.out.println("Nowa wartoœæ: ");
					data = reader.readLine();
					employees.get(i).setEmail(data);
					System.out.println("Dane zaktualizowane.");
					showEmployee(i);
					break;
				case "T":
				case "t":
					System.out.println("Nowa wartoœæ: ");
					data = reader.readLine();
					employees.get(i).setPhoneNumber(data);
					System.out.println("Dane zaktualizowane.");
					showEmployee(i);
					break;
				case "S":
				case "s":
					System.out.println("Nowa wartoœæ: ");
					data = reader.readLine();
					employees.get(i).setPosition(data);
					System.out.println("Dane zaktualizowane.");
					showEmployee(i);
					break;
				default:
					System.out.println("Nieprawid³owa wartoœæ! Operacja anulowana.");
				}
				break;
			} else {
				System.out.println("Brak pracownika o podanym loginie!");
			}
		}
	}

	public static void addEmployees() throws IOException {
		Employee employee = new Employee();
		String data;
		System.out.println('\n' + "## Dodaj pracownika:");
		System.out.print("Imie: ");
		employee.setFirstName(data = reader.readLine());
		System.out.print("Nazwisko: ");
		employee.setLastName(data = reader.readLine());
		System.out.print("Login: ");
		employee.setLogin(data = reader.readLine());
		System.out.print("Email: ");
		employee.setEmail(data = reader.readLine());
		System.out.print("Nr tel.: ");
		employee.setPhoneNumber(data = reader.readLine());
		System.out.print("Stanowisko: ");
		employee.setPosition(data = reader.readLine());
		employees.add(employee);
	}

}
