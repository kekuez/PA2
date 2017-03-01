/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2017/02/08 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
import common.MyException;
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;
        
	/**
	 * Number of times to access stack
	 */
	private int accessCounter = 0;
        /**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick() throws MyException
	{
		this.accessCounter++;
                if ( !isEmpty())
                    return this.acStack[this.iTop];
		else
                    throw new MyException("Cannot pick the stack because it is empty");
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) throws MyException
	{
		this.accessCounter++;
                if ( piPosition <= iSize - 1)
			return this.acStack[piPosition];
		else
			throw new MyException("Invalid access position of stack"); 
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws MyException
	{
		this.accessCounter++;
                if (iTop < iSize) {
                        if(this.isEmpty()){
                            this.acStack[++this.iTop] = acStack[0];
                        }
                        else{
                            this.acStack[++this.iTop] = pcBlock;
                        }
                }
                else{
			throw new MyException("Stack is full");
                }
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws MyException
	{
		this.accessCounter++;
		if ( !isEmpty())
		{
                        char cBlock = this.acStack[this.iTop];
                        this.acStack[this.iTop--] = '$'; 
                        return cBlock;
		}
		else
			throw new MyException("Stack is empty");
	}
        public int getITop()
        {
                return this.iTop;
        }
        public int getISize()
        {
                return this.iSize;
        }
        public boolean isEmpty()
        {
                return (this.iTop == -1);
        }
        public int getAccessCounter()
        {
                return this.accessCounter;
        }        
}

// EOF
