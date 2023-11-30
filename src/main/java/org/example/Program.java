package org.example;

import org.example.unit2.Animal;
import org.example.unit2.Cat;
import org.example.unit2.Dog;

import java.util.UUID;
import java.lang.reflect.*;

public class Program {

    /*
    Задача 3: Реализовать простой фреймворк для создания SQL-запросов на основе Java объектов

    Фреймворк должен позволять аннотировать классы и поля для связывания их
    с таблицами и столбцами в базе данных.

1. Аннотации для маппинга:
    Создайте аннотации, такие как @Entity, @Table, @Column для маппинга классов,
    таблиц и полей в базе данных.

2. Механизм генерации SQL-запросов:
    Реализуйте класс QueryBuilder, который может принимать объект и генерировать
    SQL-запросы для выполнения операций CRUD (Create, Read, Update, Delete) на основе аннотаций.
    Используйте Reflection для получения метаданных класса,
    аннотированного объекта, чтобы построить соответствующий SQL-запрос.
3. Пример использования:
    Создайте простой класс, аннотированный для маппинга с базой данных.
    Используйте ваш фреймворк для генерации SQL-запросов для различных операций,
    таких как вставка, выборка, обновление и удаление.
*/
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Employee user = new Employee("Stanislav", "sample@gmail.com");
        UUID pk = UUID.randomUUID();
        user.setId(pk);

        QueryBuilder queryBuilder = new QueryBuilder();
        String insertQuery = queryBuilder.buildInsertQuery(user);
        System.out.printf("Insert Query: %s\n", insertQuery);

        String selectQuery = queryBuilder.buildSelectQuery(Employee.class, pk);
        System.out.printf("Select Query: %s\n", selectQuery);

        String updateQuery = queryBuilder.buildUpdateQuery(user);
        System.out.printf("Update Query: %s\n", updateQuery);

        String deleteQuery = queryBuilder.buildDeleteQuery(Employee.class, pk);
        System.out.printf("Delete Query: %s\n", deleteQuery);

        //*****************************
        /**
         Создайте абстрактный класс "Animal" с полями "name" и "age".
         Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
         Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
         Выведите на экран информацию о каждом объекте.
         Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
         */

        Animal[] animals = new Animal[] {new Dog("Бобик",1), new Dog("Тузик",2), new Cat("Мурзик",3) };

        for(Animal animal: animals) {
            System.out.println("\nЖивотное: " + animal);
            Class<?> elementClass = animal.getClass();
            System.out.println("    Класс: " + elementClass);
            // Получить список всех полей
            Field[] fields = elementClass.getDeclaredFields();
            for (Field field : fields){
                System.out.println("    Поле: " + field);
            }
            // Получить список всех конструкторов
            Constructor[] constructors = elementClass.getConstructors();
            for (Constructor constructor : constructors){
                System.out.println("    Конструктор: " + constructor);
            }
            // Получить список всех методов
            Method[] methods = elementClass.getMethods();
            for (Method method : methods){
                System.out.println("    Метод: " + method);
            }
        }

        for(Animal animal: animals) {
            System.out.println("\nЖивотное: " + animal);
            Class<?> elementClass = animal.getClass();
            try {
                Method methodMakeSound = elementClass.getDeclaredMethod("makeSound");
                methodMakeSound.invoke(animal);
            } catch (NoSuchMethodException e) {
                System.out.println("    Метод makeSound() отсутствует.");
            }
            try {
                Method methodMakeSound = elementClass.getDeclaredMethod("hasBone");
                Object ob = methodMakeSound.invoke(animal);
                System.out.println("    Метод hasBone() вернул значение " + ob);
            } catch (NoSuchMethodException e) {
                System.out.println("    Метод hasBone() отсутствует.");
            }

        }
    }




}
