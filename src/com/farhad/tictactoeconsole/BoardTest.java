package com.farhad.tictactoeconsole;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testNew() throws Exception{
		Board position = new Board();
		assertEquals("         ", position.toString());
		assertEquals('x', position.turn);
	}
	@Test
	public void testMove() throws Exception {
		Board position = new Board().move(1);
		assertEquals(" x       ",position.toString());
		assertEquals('o',position.turn);
	}
	@Test
	public void testPossibleMoves() throws Exception {
		Board position = new Board().move(1).move(3).move(4);
		assertArrayEquals(new Integer[] {0,2,5,6,7,8}, position.possibleMoves());
	}
	@Test
	public void testWin() throws Exception {
		assertFalse(new Board().win('x'));
		assertTrue(new Board("xxx      ").win('x'));
		assertTrue(new Board("   ooo   ").win('o'));
		assertTrue(new Board("x  x  x  ").win('x'));
		assertTrue(new Board("  x x x  ").win('x'));
		assertTrue(new Board("x   x   x").win('x'));
	}
	@Test
	public void testMinmax() throws Exception {
		assertEquals( 100, new Board("xxx      ").minimax());
		assertEquals(-100, new Board("ooo      ").minimax());
		assertEquals(   0, new Board("xoxoxooxo").minimax());
		assertEquals(  99, new Board(" xx      ").minimax());
		assertEquals( -99, new Board(" oo      ",'o').minimax());
	}
	@Test
	public void testBestMove() throws Exception {
		assertEquals(0, new Board(" xx      ").bestMove());
		assertEquals(1, new Board("o o      ",'o').bestMove());
	}
	@Test
	public void testGameEnd() throws Exception {
		assertFalse(new Board().gameEnd());
		assertTrue(new Board("xxx      ").gameEnd());
	}


}
