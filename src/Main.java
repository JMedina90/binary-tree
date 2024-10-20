import java.util.Scanner;


public class Main {
    enum MenuOption {
        // Enum for the menu options in a Binary Search Tree application
        CREATE_TREE(1, "Initialize a Binary Search Tree"),
        ADD_NODE(2, "Add a node"),
        DELETE_NODE(3, "Delete a node"),
        PRINT_IN_ORDER(4, "Print InOrder"),
        PRINT_PRE_ORDER(5, "Print PreOrder"),
        PRINT_POST_ORDER(6, "Print PostOrder"),
        EXIT(7, "Exit");

        private final int option;
        private final String description;

        MenuOption(int option, String description) {
            this.option = option;
            this.description = description;
        }

        public int getOption() {
            return option;
        }

        public String getDescription() {
            return description;
        }

        public static MenuOption fromInt(int option) {
            for (MenuOption choice : values()) {
                if (choice.option == option) {
                    return choice;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        boolean treeCreated = false;

        while (true) {
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getOption() + ". " + option.getDescription());
            }
            int choice = scanner.nextInt();
            MenuOption selectedOption = MenuOption.fromInt(choice);

            if (selectedOption == MenuOption.CREATE_TREE) {
                if (!treeCreated) {
                    binaryTree.createTree();
                    treeCreated = true;
                    System.out.println("Binary search tree created with values 1, 2, 3, 4, 5, 6, 7.");
                } else {
                    System.out.println("Binary search tree already created.");
                }
            } else if (selectedOption == MenuOption.ADD_NODE) {
                System.out.println("Enter a value to add: ");
                int addValue = scanner.nextInt();
                binaryTree.addNode(addValue);
                binaryTree.printInOrder();
            } else if (selectedOption == MenuOption.DELETE_NODE) {
                System.out.print("Enter a value to delete: ");
                int addValue = scanner.nextInt();
                binaryTree.deleteNode(addValue);
                binaryTree.printInOrder();
            } else if (selectedOption == MenuOption.PRINT_IN_ORDER) {
                System.out.print("Print In Order: ");
                binaryTree.printInOrder();
                System.out.println();
            } else if (selectedOption == MenuOption.PRINT_PRE_ORDER) {
                System.out.print("Print Pre Order: ");
                binaryTree.printPreOrder();
                System.out.println();
            } else if (selectedOption == MenuOption.PRINT_POST_ORDER) {
                System.out.print("Print Post Order: ");
                binaryTree.printPostOrder();
                System.out.println();
            } else if (selectedOption == MenuOption.EXIT) {
                System.out.println("Exiting program...");
                scanner.close();
                return;
            } else {
                System.out.println("Choose a valid option");
            }

        }
    }
}
