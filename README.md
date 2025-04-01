For treasure box NPC (example ID: 18257)
```xml
<set name="type" value="TreasureChestNpc"/>
<set name="htm_root" value="custom_chest/" />
```

AI for mob to spawn treasure box after death (example ID: 18342)
```xml
<set name="ai_type" value="TreasureMob"/>
```

HTML file: html-en/custom_chest/18257.html
```html

<html><body> <center> <font color="LEVEL">You discovered a mysterious chest!</font><br><br> <button value="Open" action="bypass -h npc_%objectId%_openChest" width=200 height=30 back="L2UI_ct1.button_df" fore="L2UI_ct1.button_df"> </center> </body></html> \`\`\`