package application;

/***
 * This interface is used as a header file to hold constants
 */
public interface Constants {
	int SUGGESTED_MEMORY = 100; //can be modified by any convenient number
	int ERROR_CODE = -1;
	int ASCII_MAX = 256;
	int MULTIPLIER = 8;/*used for multiplication (i.e. << 8(MULTIPLIER value) means multiply by 2^8 = 256)
						this constant is used in the hash function*/
	 					
}
