package pl.jcode.corporation.domain;

public class Menu {

	public void mainManu() {
		System.out.println();
		System.out.println("#### MENU G��WNE ####");
		System.out.println("[1] Lista pracownik�w");
		System.out.println("[2] Dodaj");
		System.out.println("[3] Usu�");
		System.out.println("[4] Edytuj");
		System.out.println("[5] Lista by�ych pracownik�w");
		System.out.println("[6] Zako�cz");
		System.out.print("Wybierz opcje: ");
	}

	public void deleteMenu() {
		System.out.println();
		System.out.println("Czy na pewno chcesz usun�� tego pracownika?");
		System.out.println("[T] Tak");
		System.out.println("[N] Nie");
		System.out.print("Wybierz opcje: ");
	}

	public void editMenu() {
		System.out.println();
		System.out.println("Kt�re dane chcesz edytowa�?");
		System.out.println("[I] Imie");
		System.out.println("[N] Nazwisko");
		System.out.println("[L] Login");
		System.out.println("[E] Email");
		System.out.println("[T] Nr telefonu");
		System.out.println("[S] Stanowisko");
		System.out.print("Wybierz opcje: ");
	}
}
