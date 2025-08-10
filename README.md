# Дипломная работа #
## Задание 1. Юнит-тесты для Stellar Burgers
### Необходимо было протестировать класс Burger:
- метод **setBuns** (определяет булочку для бургера);
- метод **addIngredient** (добавляет ингредиент в булочку);
- метод **removeIngredient** (удаляет ингредиент из булочки);
- метод **moveIngredient** (перемещает ингредиент в булочке);
- метод **getPrice** (получить стоимость бургера);
- метод **getReceipt** (распечатать чек с информацией о бургере).

#### Подключены библиотеки: 
- **JaCoCo**; 
- **Mockito**;
- **JUnit** 4.

#### Использованы:
- **моки**;
- **стабы**;
- **параметризация**.

#### Реализованы тестовые классы:
- **TestClassBurger** (тестируются методы setBuns и getPrice);
- **TestClassBurgerAddRemoveWithParams** (тестируются методы addIngredient и removeIngredient);
- **TestClassBurgerGetReceiptWithParams** (тестируется метод getReceipt);
- **TestClassBurgerMoveWithParams** (тестируется метод moveIngredient).

**Покрытие** тестами кода класса **Burger** составляет **100%**.