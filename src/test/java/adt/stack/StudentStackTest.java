package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackImpl<Integer>(4);
		stack2 = new StackImpl<Integer>(2);
		stack3 = new StackImpl<Integer>(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTopStack1() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testTopStack2() {
		assertEquals(new Integer(2), stack2.top());
	}

	@Test
	public void testTopStack3() {
		assertEquals(null, stack3.top());
	}

	@Test
	public void testIsEmptyStack1() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsEmptyStack2() {
		assertFalse(stack2.isEmpty());
	}

	@Test
	public void testIsEmptyStack3() {
		assertTrue(stack3.isEmpty());
	}

	@Test
	public void testIsFullStack1() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testIsFullStack2() {
		assertTrue(stack2.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testIsFullStack3() {
		assertFalse(stack3.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPushStack1() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPushStack2() {
		try {
			stack2.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPushStack3() {
		try {
			stack3.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErroStack1() throws StackOverflowException {
		stack1.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
		stack1.push(new Integer(5));								// permitir outra insercao
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErroStack2() throws StackOverflowException {
		stack2.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErroStack3() throws StackOverflowException {
		stack3.push(new Integer(5));
		stack3.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test
	public void testPopStack1() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPopStack2() {
		try {
			assertEquals(new Integer(2), stack2.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPopStack3() {
		try {
			assertEquals(new StackUnderflowException(), stack3.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErroStack1() throws StackUnderflowException {
		assertEquals(new Integer(3), stack1.pop()); // levanta excecao apenas se
		assertEquals(new Integer(2), stack1.pop());// stack1 for vazia
		assertEquals(new Integer(1), stack1.pop());	
		assertEquals(new StackUnderflowException(), stack1.pop());										
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErroStack2() throws StackUnderflowException {
		assertEquals(new Integer(2), stack2.pop()); // levanta excecao apenas se
		assertEquals(new Integer(1), stack2.pop()); // stack1 for vazia			
		assertEquals(new StackUnderflowException(), stack2.pop());										
	}

}