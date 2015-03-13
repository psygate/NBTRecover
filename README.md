# NBTRecover
Allows users to operate on offline bukkit NBTag player data and load corrupted data.

Commands
========

NBTpurgePlayer
--------------

* aliases: [nbtpp]
* descritpion: Purges all player records found. USE THIS WITH CAUTION. MAKE BACKUPS.
* permission: nbtrecover.player.purge
* permission-message: You are not allowed to use this.
* usage: /NBTpurgePlayer <name> (<name> <name> ...)

NBTloadInventory
----------------

* aliases: [nbtli]
* description: Deletes your current inventory and replaces it with the inventory of the specified player. If there's more than one record, the last one will be used.
* permission: nbtrecover.player.loadinv
* permission-message: You are not allowed to use this.
* usage: /NBTloadInventory <name> <Timestamp>

NBTList
-------

* aliases: [nbtl]
* description: Lists found records for a player.
* permission: nbtrecover.player.list
* permission-message: You are not allowed to use this.
* usage: /NBTList <name> (<name> <name> ...)

NBTLoadAll
----------

* aliases: [nbtla]
* description: Loads all records for players into chests in front of you.
* permission: nbtrecover.player.loadall
* permission-message: You are not allowed to use this.
* usage: /NBTLoadAll <name> (<name> <name> ...)

NBTClearStates
--------------

* aliases: [nbtcs]
* description: Clears yours, or all states.
* permission: nbtrecover.player.clearstates
* permission-message: You are not allowed to use this.
* usage: /NBTClearStates (all)
