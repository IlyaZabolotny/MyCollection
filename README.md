## 1. Сравнение производительности своей коллекции и Java реализации
Количество элементов в коллекции 10000.
1. добавление элемента  
MyLinkedList - 15.9254 ms  
java.util.LinkedList - 8.267 ms
2. поиск элемента  
MyLinkedList - 90.2503 ms  
java.util.LinkedList - 49.2048 ms
3. удалание элемента  
MyLinkedList - 0.823 ms  
java.util.LinkedList - 0.5115 ms
## 2. Сравнительный анализ производительности основных Java коллекций  
Количество элементов в коллекции 100000.  
a.  **ArrayList**   
add elements 40.9961 ms  
get elements from begin 4.6591 ms  
get elements from middle 6.6424 ms  
get elements from end 0.1132 ms  
insert elements to begin 1548.878 ms  
insert elements to middle 674.3348 ms  
remove elements from begin 1517.0051 ms  
remove elements from middle 64.6767 ms  
remove elements from end 6.6444 ms   
**LinkedList**  
add elements 33.4178 ms  
get elements from begin 4.2719 ms  
get elements from middle 27821.0484 ms  
get elements from end 0.3473 ms  
insert elements to begin 11.3699 ms  
insert elements to middle 130608.5292 ms  
remove elements from begin 6.4497 ms  
remove elements from middle 130158.6755 ms  
remove elements from end 7.9742 ms   
b. **HashSet**  
add 20.2832 ms  
contains 23.8526 ms  
remove 45.7253 ms  
**LinkedHashSet**  
add 16.4183 ms  
contains 28.4686 ms  
remove 22.5217 ms  
**TreeSet**  
add 63.4275 ms  
contains 64.6225 ms  
remove 73.9335 ms  
c. **HashMap**  
put 19.8595 ms  
contains 40.5138 ms  
remove 18.5986 ms  
**LinkedHashMap**  
put 29.1437 ms  
contains 22.6426 ms  
remove 18.3556 ms  
**TreeMap**  
put 37.7626 ms  
contains 43.7455 ms  
remove 100.8071 ms  
### Вывод:  
ArrayList и LinkedList - упорядоченные списки. ArrayList - индексированный список, базирующийся на массиве. 
LinkedList - связанный список. Из полученных данных следует, что LinkedList следует использовать, когда необходимо вставлять много данных в начало списка и удалять первые элементы из списка.
ArrayList  - когда необходимо получить элементы по индексу get, удалять элементы из конца и середины списка.
Set - множество уникальных элементов. HashSet (использует HashMap) удобно использовать, когда необходимо хранить элементы без дублирования. Порядок элементов не важен. 
В LinkedHashSet (использует LinkedHashMap) порядок элементов соответствует последовательности добавления в коллекцию. TreeSet (использует TreeMap) необходим, если нужно хранить элементы в порядке возрастания.
Операции add, contains и remove в HashSet выполняются за O(1). LinkedHashSet хуже в производительности за счет сохранения порядка вставки элементов, использования связанного списка. 
Операции вставки, удаления элементов в TreeSet проигрывают HashSet, LinkedHashSet из-за сохранения порядка возрастяния элементов. Выполняются за время O(log(n)).  
Map - ассоциативный массив вида ключ-значение. Ключи должны быть уникальными. Свойства HashMap, LinkedHashMap и TreeMap аналогичны свойствам HashSet, LinkedHashSet и TreeSet.

