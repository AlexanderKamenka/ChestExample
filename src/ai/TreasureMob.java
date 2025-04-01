package ai;

import l2.gameserver.ai.Fighter;
import l2.gameserver.data.xml.holder.NpcHolder;
import l2.gameserver.listener.actor.OnDeathListener;
import l2.gameserver.model.Creature;
import l2.gameserver.model.Player;
import l2.gameserver.model.SimpleSpawner;
import l2.gameserver.model.instances.NpcInstance;
import l2.gameserver.templates.npc.NpcTemplate;
import l2.gameserver.utils.Location;

public class TreasureMob extends Fighter implements OnDeathListener {

    private static final int CHEST_NPC_ID = 18257;

    public TreasureMob(NpcInstance actor) {
        super(actor);
        actor.addListener(this);
    }

    @Override
    public void onDeath(Creature killer, Creature victim) {
        Location loc = getActor().getLoc();

        try {
            NpcTemplate template = NpcHolder.getInstance().getTemplate(CHEST_NPC_ID);
            if (template == null) {
                System.out.println("❌ Chest NPC template not found for ID: " + CHEST_NPC_ID);
                return;
            }

            SimpleSpawner spawner = new SimpleSpawner(template);
            spawner.setLoc(loc);
            spawner.setAmount(1);
            spawner.setRespawnDelay(0);
            spawner.setReflection(killer.getReflection());

            NpcInstance npc = spawner.doSpawn(true);
            npc.setSpawn(null);

            System.out.println("✅ Chest spawned at: " + loc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (killer != null && killer.isPlayer()) {
            Player player = killer.getPlayer();
            player.sendMessage("🎁 A treasure chest has appeared!");
        }
    }
}
