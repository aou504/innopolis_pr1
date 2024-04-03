import java.util.Scanner;

class Contact {
    String name;
    String value;

    public Contact(String name, String value) {
        this.name = name;
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) {
        Contact[] contacts = new Contact[10];
        Scanner scanner = new Scanner(System.in);

        int menuChoice;
        boolean exit = false;
        int contactIndex = 0;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Новый контакт");
            System.out.println("2. Редактировать контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Выйти");

            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("Введите имя нового контакта:");
                    String newName = scanner.next();
                    System.out.println("Введите номер нового контакта:");
                    String newValue = scanner.next();
                    contacts[contactIndex] = new Contact(newName, newValue);
                    contactIndex++;
                    break;
                case 2:
                    System.out.println("Выберите индекс контакта для редактирования:");
                    int editIndex = scanner.nextInt();
                    System.out.println("Введите новое имя контакта:");
                    contacts[editIndex - 1].name = scanner.next();
                    System.out.println("Введите новый номер контакта:");
                    contacts[editIndex - 1].value = scanner.next();
                    break;
                case 3:
                    System.out.println("Выберите индекс контакта для удаления:");
                    int deleteIndex = scanner.nextInt();
                    contacts[deleteIndex - 1] = null;
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
            }

            for (int i = 0; i < contacts.length; i++) {
                if (contacts[i] != null) {
                    System.out.println((i + 1) + ". " + contacts[i].name + " " + contacts[i].value);
                } else {
                    System.out.println((i + 1) + ". ...");
                }
            }
        }
    }
}
