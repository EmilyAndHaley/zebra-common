package com.runningwithzebras.parsers.dom;

public interface DomParser<I, O> {
	O ObjectFromDOM(I source);

}
