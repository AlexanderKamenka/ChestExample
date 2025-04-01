for treasure box Npc set-example 18257 ID
<set name="type" value="TreasureChestNpc"/>
<set name="htm_root" value="custom_chest/" />

ai for mob to spawn treasure box after death-example 18342
<set name="ai_type" value="TreasureMob"/>


html-en/custom_chest/18257.html file--
/*
<html><body>
<center>
    <font color="LEVEL">You discovered a mysterious chest!</font><br><br>
    <button value="Open" action="bypass -h npc_%objectId%_openChest" width=200 height=30 back="L2UI_ct1.button_df" fore="L2UI_ct1.button_df">
</center>
</body></html>
*/