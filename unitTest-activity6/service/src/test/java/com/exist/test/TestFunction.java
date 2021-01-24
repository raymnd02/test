package com.exist.test;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.*;
import com.exist.model.Table;
import com.exist.service.*;
// import junit.framework.TestCase;


public class TestFunction {
	Function function = new Function();
	ArrayList<ArrayList<Table>> table = new ArrayList<ArrayList<Table>>();
	ArrayList<ArrayList<Table>> returnTable = new ArrayList<>();
	
	@Before
	public void setUp() {
		table.add(new ArrayList<Table>(Arrays.asList(new Table("aaa","aaa"),new Table("bbb","bbb"))));
		table.add(new ArrayList<Table>(Arrays.asList(new Table("ccc","ccc"),new Table("ddd","ddd"))));
	}
	
	@After
	public void tearDown() {
		returnTable.clear();
	}
	
	@Test
	public void testSort() {
		System.out.println("Testing on search()");
		
		returnTable = function.sort(0,1,table);
		assertEquals("aaa",returnTable.get(0).get(0).getKey());
		returnTable = function.sort(0,2,table);
		assertEquals("bbb",returnTable.get(0).get(0).getKey());
	}
	
	@Test 
	public void testEdit() {
		System.out.println("Testing on edit()");
		returnTable = function.edit(1,1,1,"eee",table);
		assertEquals("eee",returnTable.get(1).get(1).getKey());
		returnTable = function.edit(1,0,2,"eee",table);
		assertEquals("eee",returnTable.get(1).get(0).getValue());
	}
	
	@Test
	public void testReset() {
		System.out.println("Testing on reset()");
		returnTable = function.reset(2,4);
		assertEquals(2,returnTable.size());
		assertEquals(4,returnTable.get(0).size());
	}
	
}