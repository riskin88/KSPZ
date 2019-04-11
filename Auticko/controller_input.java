import com.exlumina.j360.J360;
import com.exlumina.j360.XInputState;

public class controller_input {
    
	public static void main(String... args) throws InterruptedException
    {
        XInputState pState = new XInputState();
        
        while (true)
        {
            for (int p = 0; p < J360.XUSER_MAX_COUNT; ++p)
            {
                if (J360.XInputGetState(p, pState) == J360.ERROR_SUCCESS)
                {
                    System.out.printf("D %d ",
                                      (pState.Gamepad.sThumbLX));
					System.out.printf("%d\n",
                                      (pState.Gamepad.sThumbLY));
					
					System.out.printf("S %d\n",
                                      (pState.Gamepad.bRightTrigger  & 0xFF));
                }
            }
			if ((pState.Gamepad.wButtons & J360.XINPUT_GAMEPAD_X) != 0)
				System.exit(0);
            
            System.out.println();
            
            Thread.sleep(5);
        }
    }
}