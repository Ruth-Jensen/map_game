import java.util.ArrayList;
import java.util.List;

public class Player
{
    private static List<Item> _inventory = new ArrayList<>();

    public Player(){ }

    public static List<Item> GetInventory() { return _inventory; }
    public static void AddToInventory(Item item) { _inventory.add(item); }
    public static void RemoveFromInventory(Item item) { _inventory.remove(item); }
}