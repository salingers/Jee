Number.prototype.format_time = function(){						
	return this < 10 ? ("0" + this) : this;
}