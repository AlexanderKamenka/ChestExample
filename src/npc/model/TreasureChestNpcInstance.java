package npc.model;

import l2.gameserver.model.Player;
import l2.gameserver.model.instances.NpcInstance;
import l2.gameserver.templates.npc.NpcTemplate;

public class TreasureChestNpcInstance extends NpcInstance {

    public TreasureChestNpcInstance(int objectId, NpcTemplate template) {
        super(objectId, template);
    }

    @Override
    public void onBypassFeedback(Player player, String command) {
        if (!canBypassCheck(player, this)) {
            return;
        }

        System.out.println("Command received: " + command);

        if (command.startsWith("npc_")) {
            int secondUnderscore = command.indexOf("_", 4);
            if (secondUnderscore != -1) {
                command = command.substring(secondUnderscore + 1);
            }
        }

        switch (command) {
            case "openChest":
                System.out.println("Opening chest...");
                giveRandomItem(player);
                deleteMe();
                break;

            default:
                super.onBypassFeedback(player, command);
                break;
        }
    }


    private void giveRandomItem(Player player) {
        int[][] possibleItems = {
                {57, 10000},    // Adena
                {4037, 5},      // Blessed Scroll of Escape
                {1463, 100},    // Soulshot S-grade
                {1538, 1},      // Blessed Resurrection
                {8689, 1}       // Firework
        };

        int index = (int) (Math.random() * possibleItems.length);
        int itemId = possibleItems[index][0];
        int count = possibleItems[index][1];


        player.getInventory().addItem(itemId, count);
        player.sendMessage("🎁 You opened the chest and received: " + count + " x " + itemId + "!");
    }

    @Override
    public String getHtmlPath(int npcId, int val, Player player) {
        return "custom_chest/" + npcId + ".htm";

    }
}
