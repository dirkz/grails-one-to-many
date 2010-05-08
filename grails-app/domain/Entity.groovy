class Entity {

	static hasMany = [children:Entity]
	static belongsTo = [parent:Entity]
	                    
	public String toString() {
		return "${id}"
	}

}
