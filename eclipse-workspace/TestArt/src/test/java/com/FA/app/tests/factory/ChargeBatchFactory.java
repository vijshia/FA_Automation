/**
 * 
 */
package com.FA.app.tests.factory;

import java.util.ArrayList;

import org.testng.annotations.Factory;

import com.FA.app.tests.baseFactory;
import com.FA.app.tests.test.ChargeBatchTest;

/**
 * @author AJP16088
 *
 */
public class ChargeBatchFactory extends baseFactory {
	
	@Factory(dataProvider = "allDataProvider")
    public Object[] testFactory(ArrayList<String[]> allDataProvider) {
        return new Object[]{new ChargeBatchTest(allDataProvider)};
    }

}
