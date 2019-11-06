package io.turntabl.entering_details;

import org.junit.Test;

public class Client_info_entryTest {


        @Test
        public void getInput() {
            Client_info_entry info = new Client_info_entry(getInput());
            System.out.println(info);
        }

}
