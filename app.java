public class app {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore("prize_toys.txt");

        // Добавляем новые игрушки
        toyStore.addNewToy(1, "Кукла", 10, 20);
        toyStore.addNewToy(2, "Мяч", 15, 30);
        toyStore.addNewToy(3, "Конструктор", 5, 15);
        toyStore.addNewToy(4, "Пазл", 25, 10);
        toyStore.addNewToy(5, "Неваляшка", 12, 15);
        toyStore.addNewToy(6, "Водяной пистолет ", 9, 20);

        // Обновляем вес (частоту выпадения) игрушки
        toyStore.updateToyWeight(1, 25);

        // Розыгрыш призовой игрушки
        toyStore.drawPrizeToy();

        // Сохраняем призовые игрушки в файл
        toyStore.savePrizeToysToFile();
    }
}
    

