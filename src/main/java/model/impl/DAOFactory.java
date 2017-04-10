package model.impl;


public class DAOFactory {

	private static DAOFactory instance;
	private AddressDAOImpl addressDAOImpl;
	private CityDAOImpl cityDAOImpl;
	private ContractDAOImpl contractDAOImpl;
	private ContractTypeDAOImpl contractTypeDAOImpl;
	private CountryDAOImpl countryDAOImpl;
	private CustomerDAOImpl customerDAOImpl;
	private InventoryCheckDAOImpl inventoryCheckDAOImpl;
	private ItemDAOImpl itemDAOImpl;
	private JobDAOImpl jobDAOImpl;
	private LocationDAOImpl locationDAOImpl;
	private PersonDAOImpl personDAOImpl;
	private PersonTypeDAOImpl personTypeDAOImpl;
	private PurchaseDAOImpl purchaseDAOImpl;
	private PurchasingItemDAOImpl purchasingItemDAOImpl;
	private SalesDAOImpl salesDAOImpl;
	private SalesItemDAOImpl salesItemDAOImpl;
	private StockMoveDAOImpl stockMoveDAOImpl;
	private StockMoveTypeDAOImpl stockMoveTypeDAOImpl;
	private SuppliersDAOImpl suppliersDAOImpl;
	private UnitDAOImpl unitDAOImpl;
	private UserDAOImpl userDAOImpl;
	private UserRoleDAOImpl userRoleDAOImpl;
	private WarehouseDAOImpl warehouseDAOImpl;


	private DAOFactory() {

	}

	public static synchronized DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	public AddressDAOImpl getAddressDAOImpl() {
		if(addressDAOImpl == null){
			addressDAOImpl = new AddressDAOImpl();
		}
		return addressDAOImpl;
	}

	public CityDAOImpl getCityDAOImpl() {
		if(cityDAOImpl == null){
			cityDAOImpl = new CityDAOImpl();
		}
		return cityDAOImpl;
	}

	public ContractDAOImpl getContractDAOImpl() {
		if(contractDAOImpl == null){
			contractDAOImpl = new ContractDAOImpl();
		}
		return contractDAOImpl;
	}

	public ContractTypeDAOImpl getContractTypeDAOImpl() {
		if(contractTypeDAOImpl == null){
			contractTypeDAOImpl = new ContractTypeDAOImpl();
		}
		return contractTypeDAOImpl;
	}

	public CountryDAOImpl getCountryDAOImpl() {
		if(countryDAOImpl == null){
			countryDAOImpl = new CountryDAOImpl();
		}
		return countryDAOImpl;
	}

	public CustomerDAOImpl getCustomerDAOImpl() {
		if(customerDAOImpl == null){
			customerDAOImpl = new CustomerDAOImpl();
		}
		return customerDAOImpl;
	}

	public InventoryCheckDAOImpl getInventoryCheckDAOImpl() {
		if(inventoryCheckDAOImpl == null){
			inventoryCheckDAOImpl = new InventoryCheckDAOImpl();
		}
		return inventoryCheckDAOImpl;
	}

	public ItemDAOImpl getItemDAOImpl() {
		if(itemDAOImpl == null){
			itemDAOImpl = new ItemDAOImpl();
		}
		return itemDAOImpl;
	}

	public JobDAOImpl getJobDAOImpl() {
		if(jobDAOImpl == null){
			jobDAOImpl = new JobDAOImpl();
		}
		return jobDAOImpl;
	}

	public LocationDAOImpl getLocationDAOImpl() {
		if(locationDAOImpl == null){
			locationDAOImpl = new LocationDAOImpl();
		}
		return locationDAOImpl;
	}

	public PersonDAOImpl getPersonDAOImpl() {
		if(personDAOImpl == null){
			personDAOImpl = new PersonDAOImpl();
		}
		return personDAOImpl;
	}

	public PersonTypeDAOImpl getPersonTypeDAOImpl() {
		if(personTypeDAOImpl  == null){
			personTypeDAOImpl = new PersonTypeDAOImpl();
		}
		return personTypeDAOImpl;
	}

	public PurchaseDAOImpl getPurchaseDAOImpl() {
		if(purchaseDAOImpl == null){
			purchaseDAOImpl = new PurchaseDAOImpl();
		}
		return purchaseDAOImpl;
		
	}

	public PurchasingItemDAOImpl getPurchasingItemDAOImpl() {
		if(purchasingItemDAOImpl == null){
			purchasingItemDAOImpl = new PurchasingItemDAOImpl();
		}
		return purchasingItemDAOImpl;
	}

	public SalesDAOImpl getSalesDAOImpl() {
		if(salesDAOImpl == null){
			salesDAOImpl = new SalesDAOImpl();
		}
		return salesDAOImpl;
	}

	public SalesItemDAOImpl getSalesItemDAOImpl() {
		if(salesItemDAOImpl == null){
			salesItemDAOImpl = new SalesItemDAOImpl();
		}
		return salesItemDAOImpl;
	}

	public StockMoveDAOImpl getStockMoveDAOImpl() {
		if(stockMoveDAOImpl == null){
			stockMoveDAOImpl = new StockMoveDAOImpl();
		}
		return stockMoveDAOImpl;
	}

	public StockMoveTypeDAOImpl getStockMoveTypeDAOImpl() {
		if(stockMoveTypeDAOImpl == null){
			stockMoveTypeDAOImpl = new StockMoveTypeDAOImpl();
		}
		return stockMoveTypeDAOImpl;
	}

	public SuppliersDAOImpl getSuppliersDAOImpl() {
		if(suppliersDAOImpl == null){
			suppliersDAOImpl = new SuppliersDAOImpl();
		}
		return suppliersDAOImpl;
	}

	public UnitDAOImpl getUnitDAOImpl() {
		if(unitDAOImpl == null){
			unitDAOImpl = new UnitDAOImpl();
		}
		return unitDAOImpl;
	}

	public UserDAOImpl getUserDAOImpl() {
		if(userDAOImpl == null){
			userDAOImpl = new UserDAOImpl();
		}
		return userDAOImpl;
	}

	public UserRoleDAOImpl getUserRoleDAOImpl() {
		if(userRoleDAOImpl == null){
			userRoleDAOImpl = new UserRoleDAOImpl();
		}
			return userRoleDAOImpl;
		
	}

	public WarehouseDAOImpl getWarehouseDAOImpl() {
		if(warehouseDAOImpl == null){
			warehouseDAOImpl = new WarehouseDAOImpl();
		}
		return warehouseDAOImpl;
	}
	

}
