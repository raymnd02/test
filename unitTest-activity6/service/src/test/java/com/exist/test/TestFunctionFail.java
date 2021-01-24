package com.exist.test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import com.exist.model.Table;
import com.exist.service.*;
// import junit.framework.TestCase;

public class TestFunctionFail {
	Function function = new Function();
	ArrayList<ArrayList<Table>> table = new ArrayList<ArrayList<Table>>();
	ArrayList<ArrayList<Table>> returnTable = new ArrayList<>();
	
	@Before
	public void setUp() {
		table.add(new ArrayList<Table>(Arrays.asList(new Table("aaa","aaa"),new Table("bbb","bbb"))));
		table.add(new ArrayList<Table>(Arrays.asList(new Table("ccc","ccc"),new Table("ddd","ddd"))));
	}
	
	@After
	public void tearDown(){
		returnTable.clear();
	}
	
	@Test
	public void testEdit() {
		System.out.println("Testing on edit()");
		returnTable = function.edit(1,1,1,"eee",table);
		assertEquals("ee",returnTable.get(1).get(1).getKey());
		returnTable = function.edit(1,0,2,"eee",table);
		assertEquals("ee",returnTable.get(1).get(0).getValue());
	}
	
	@Test
	public void testSort() {
		System.out.println("Testing on search()");
		returnTable = function.sort(0,1,table);
		assertEquals("aa",returnTable.get(0).get(0).getKey());
		returnTable = function.sort(0,2,table);
		assertEquals("bb",returnTable.get(0).get(0).getKey());
	}
	
	@Test
	public void testReset() {
		System.out.println("Testing on reset()");
		returnTable = function.reset(2,4);
		assertEquals(4,returnTable.size());
		assertEquals(2,returnTable.get(0).size());
	}
	
}