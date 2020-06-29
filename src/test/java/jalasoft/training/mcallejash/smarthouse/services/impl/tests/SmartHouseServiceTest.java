package jalasoft.training.mcallejash.smarthouse.services.impl.tests;

import jalasoft.training.mcallejash.smarthouse.core.ManagerType;
import jalasoft.training.mcallejash.smarthouse.dao.IDataFeedDao;
import jalasoft.training.mcallejash.smarthouse.dao.stub.DataFeedStubDao;
import jalasoft.training.mcallejash.smarthouse.services.impl.SmartHouseService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class SmartHouseServiceTest {
    @Mock
    private IDataFeedDao mockDao = new DataFeedStubDao();

    @InjectMocks
    private SmartHouseService smartHouseService = new SmartHouseService(mockDao);

    @BeforeEach
    void setUp() {

    }

    @Test
    void getHubs_IsNotEmpty() {
        //Arrange
        int expected = 1;
        //Act
        int actual = this.smartHouseService.GetHubs().size();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    void triggerActionOnManager_ChangesItsStatus() {
        //Arrange
        ManagerType managerType = ManagerType.Sensor;
        boolean original = this.smartHouseService.GetHubs().get(0).getManagers().get(0).isOn(); // known index from dao
        //Act
        this.smartHouseService.TriggerActionOnManager(managerType, true);
        boolean updated = this.smartHouseService.GetHubs().get(0).getManagers().get(0).isOn(); // known index from dao
        //Assert
        Assert.assertNotEquals(updated, original);
    }

    @Test
    void unlinkDeviceFromManager_reducesDevicesSizeByOne() {
        //Arrange
        ManagerType managerType = ManagerType.Sensor;
        int original = this.smartHouseService.GetHubs().get(0).getManagers().get(0).getDevices().size(); // known index from dao
        //Act
        this.smartHouseService.UnlinkDeviceFromManager(managerType, 1);
        int updated = this.smartHouseService.GetHubs().get(0).getManagers().get(0).getDevices().size(); // known index from dao
        //Assert
        Assert.assertEquals(updated, original - 1);
    }
}