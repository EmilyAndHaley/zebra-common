package com.runningwithzebras.parsers.json;

public interface JsonParser<I, O> {
	O ObjectFromJSON(I source);
}
