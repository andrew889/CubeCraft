package net.minezbot.cubecraft.Util.Errors;

public enum ErrorCode {

	CLASS_ITEMS_NOT_FOUND ("CLASS_ITEMS_NOT_FOUND", 1), 
	CHAT_MESSAGE_NOT_SENT ("CHAT_MESSAGE_NOT_SENT", 2), 
	CUBECRAFT_PACK_NOT_SPAWNED ("CUBECRAFT_PACK_NOT_SPAWNED", 3), 
	HEALTH_NOT_SET ("HEALTH_NOT_SET", 4), 
	UPGRADE_FAILED ("UPGRADE_FAILED", 5), 
	ENCHANT_FAILED ("ENCHANT_FAILED", 6), 
	MESSAGE_NOT_SENT ("MESSAGE_NOT_SENT", 7), 
	BROADCAT_NOT_SENT ("BROADCAT_NOT_SENT", 8), 
	SIGN_NOT_BUILT ("BROADCAT_NOT_SENT", 9),
	CLASS_NOT_FOUND ("CLASS_NOT_FOUND", 10),
	ENITIY_PACK_TYPE_NOT_FOUND ("ENITIY_PACK_TYPE_NOT_FOUND", 11),
	ENTITY_PACK_UUID_NOT_FOUND ("ENTITY_PACK_UUID_NOT_FOUND", 12),
	PLAYER_CLASS_NOT_FOUND ("PLAYER_CLASS_NOT_FOUND", 13);
	
	private final String name;
	private final int value;
	
	private ErrorCode(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return value;
	}

}
