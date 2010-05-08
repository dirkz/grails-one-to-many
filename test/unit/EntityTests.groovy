import grails.test.*

class EntityTests extends GrailsUnitTestCase {

	protected void setUp() {
        super.setUp()
        mockDomain(Entity)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAddToOwned() {
    	def parent = new Entity()
    	def success = parent.save()
    	assertNotNull(success)
    	assertNotNull(parent.id)
    	
    	def child = new Entity()
    	parent.addToChildren(child)
    	child.parent = parent

    	success = parent.save()
    	assertNotNull(success)
    	assertNotNull(parent.id)
    	
    	success = child.save()
    	assertNotNull(success)
    	assertNotNull(child.id)
    	
    	assertTrue(child.id != parent.id)

    	assertNotNull(parent.children)
    	assertTrue(parent.children.size() == 1)
    	
    	assertTrue("child.children ${child.children}", child.children == null || child.children.size() == 0)
    }

}
