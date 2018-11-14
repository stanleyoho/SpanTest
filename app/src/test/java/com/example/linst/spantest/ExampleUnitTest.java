package com.example.linst.spantest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
	@Test
	public void addition_isCorrect() {
		String context = "我国南部一些岛屿，<_>大自然的勃勃生机，还有美丽的海景与宁静的<_>。/n 政府准许发展商在岛上建造度假胜地或住宅，但<_>不可建造太高的建筑物，建筑物的数目也有限制，以避免<_>到岛上的树木与自然生态。/n 政府也将要求发展商在建造的时候，应该在水里加上过滤网，减少对邻近海域的<_>。\n据了解，发展项目建成后，岛上也不<_>开车。为减少空气和噪音污染，岛上只能骑脚踏车和开高尔夫球车。\n";

		context.replaceAll("\n","");

		System.out.println(context);

		assertEquals(4, 2 + 2);
	}
}