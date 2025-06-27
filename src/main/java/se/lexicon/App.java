package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        // call more methods as needed
        //NameRepository.clear();
        String[] newArray = NameRepository.findAll();
        System.out.println(newArray.length);
        System.out.println(NameRepository.find("Erik Svensson"));
        NameRepository.add("Mykyta Shadrin");
        System.out.println(NameRepository.getSize());
        NameRepository.findByFirstName("Maksim");
        newArray = NameRepository.findByLastName("Shadrin");
        System.out.println(newArray.length);

    }
}
