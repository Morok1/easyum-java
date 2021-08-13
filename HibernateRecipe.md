### 1-3 Configuring Hibernate
- Problem 
How do you configure a Java project that uses an object/relational framework such as Hibernate as a persistence framework? How do you configure Hibernate programmatically?
### 1-4 Configuring Hibernate
- Problem  
Is there a generalized mechanism to configure ORM with less dependency on individual providers such as Hibernate, TopLink, and so on?
### 1-5 Enabling Logging in Hibernate
- Problem 
How do you determine what SQL query is being executed by Hibernate? How can you see the Hibernate’ internal workings? How do you enable logging to troubleshoot complex issues related to Hibernate?
- Key Points
### 2-1 Providing an ID for Persistence
- Problem 
How do you generate an identifier for a database entity? What are possible strategies?
- Key Points
1. If no sequence name is specified, hibernate_sequence is created
2. Increment maximum primary key column
3. The hilo generator is used for batch operations.
4. Enhanced Sequence Style Generator (pooled)
### 2-2. Creating a Composite Key in Hibernate
- Problem 
How do you create a composite key in Hibernate?
- Key Points
### 2-3. saveOrUpdate( ) in Hibernate
 - Problem 
 How do save and update work for the saveOrUpdate() method in Hibernate?
 - Key Points
1.Hibernate makes it persistent by generating the identifier(insert) and assigning it to a session. 
If the object already has an identifier, it performs update()
2. 
### 2-4. Dynamic SQL Generation in Hibernate
- Problem 
What does dynamic SQL generation mean? Why do you need to enable it and how do you do so?
- Key Points
1.On application startup, Hibernate creates SQL statements for each of its persistent classes.
Dynamic update switch off this feature

### 3-1. Implementing a Value Type as a Component
- Problem 
How do you create a component? How do you create a fine-grained object model to map to a single row in a relational model?
- Key Points
1. Component(xml) or embedable (annotation)
### 3-2. Nesting Components
- Problem 
How do you nest a component within another component?
- Key Points
1.component in component(xml)

### 3-3. Adding References in Components
- Problem 
How do you add a reference to a component’s parent object? How do you provide associations within a component?
- Key Points
1.You can add a reference to the parent object by using the <parent> tag.
### 3-4. Mapping a Collection of Components
- Problem 
Does Hibernate support mapping a collection of dependent objects? How do you map a collection of components?
- Key Points
### 3-5. Using Components as Keys to a Map
- Problem 
Normally, the key to a map can be a String type, a Long type, an Integer type, and so on. But what if you need to implement your own map key? Does Hibernate allow you to map a component class as a key to a map? If so, how do you map components as keys to a map?
- Key Points

### 4-1. Mapping Entities with Table per Class Hierarchy
- Problem 
How do you map entities using the table per class hierarchy strategy? And when should you use it?
- Key Points
  1. SINGLE_TABLE (as used here), which means that a single table is used for all subclasses, with various columns being ignored if a subclass doesn’t need them;
  2. TABLE_PER_CLASS, which means that each subclass gets its own table, with the superclass’ columns being present in the subclass’ tables as well  
  3. JOINED, which means that fields specific to a subclass get mapped to a table specific to that class.
  4. More concretly https://orientdb.org/docs/3.1.x/teleporter/Teleporter-Inheritance.html
### 4-2. Mapping Entities with Table per Subclass
- Problem 
How do you map entities using the table per subclass strategy? And when should you use it?
- Key Points
1. This strategy has an advantage in that it’s normalized
2. performance issue
3.  JOINED


### 4-3. Mapping Entities with Table per Concrete Class
- Problem 
How do you map entities using the table per concrete class strategy? And when should you use it?
- Key Points
1.the main difference is specifying a different identity generation strategy and a different inheritance model:
2.UNION id is same from sequence
### 4-4. Mapping Entities with Table per Class with a Mapped Superclass
- Problem 
What kind of mapping can support a structure in which a superclass contains common attributes, but is abstract?
- Key Points  
### 4-5. Custom Mappings
- Problem 
What are the various extensions that Hibernate provides to implement custom mapping types? How do you
    create UserType custom mapping?
- Key Points
  0. Extra logic for work with types(value type)
  1. The extensions are listed in the org.hibernate.usertype package and are as follows:
  2. CompositeUserType: Exposes the internals of the value type to Hibernate, which allows querying for specific internal properties.
  3. EnhancedUserType: Used when marshalling value types to and from XML is required. It lets you use the custom type in identifier and discriminator mappings.
  4. LoggableUserType: Used when you want custom logging of the corresponding value types.
  5. ParameterizedType: Used when you want to set parameters for a type by using a nested type element for the property element in the mapping file or by defining a typedef.
  6. UserCollectionType: Used when you want to implement a custom collection mapping type and when you have to persist a non–JDK type collection.
  7. UserType: A basic extension point that provides a basic framework to implement custom loading and storing of value type instances.
  8. UserVersionType: Used for a version property.
### 5-1. Using Many-To-One Associations
- Problem 
Imagine you are a publisher with many books. Because you value what your readers have to contribute, you allow them to submit errata for a given book, and the errata go through a process by which they’re sent to the author or discarded. In this example, Book13 has a set of ReaderErrata1.4 The relationship between ReaderErrata1 and Book1 is a many-to-one relationship. How can this be mapped? How can you cascade changes throughout the hierarchy?
- Key Points
### 5-2 Using a Many-to-One Association with a Join Table
- Problem 
Sometimes you don’t want an association polluting your domain model. In the first recipe, ReaderErrata1 had a reference to Book1, which makes perfect sense because if there were no book, an error wouldn’t exist for it. Let’s consider a publisher-matching service instead, in which publishers who have published no books can exist, and books can exist without publishers.
For this example, we don’t want to pollute the database model for our books with references to publishers; this implies the use of a join table (a table with references to the different participants in the relationship). A join table gives us a more normal schema for our database.
How do you represent this data structure in Hibernate? And what are the additional features that it provides to manage this kind of association?
### 5-3. Using Lazy Initialization on Many-to-One Associations
- Problem 
In an association between two entities in an ORM framework, when the data of one entity is loaded from the database, the data of the dependent entity can be fetched along with it or loaded on demand.
For example, in the case of Book1 and ReaderErrata1 from Recipe 5.1, the READERERRATA1 table has the foreign key column book_id. If ReaderErrata1 details are fetched from the database, should the Book1 details be loaded along with them, or should the Book1 details be retrieved only when you explicitly fetch them? When the dependent object’s details are loaded only on demand, they’re said to be lazily loaded. By lazily loading data, you can improve performance because unnecessary queries aren’t executed.
How is lazy initialization achieved in Hibernate? What effect does it have when you’re retrieving an object graph? And what are the ways to deal with it?
- Key Points
### 5-5. Creating a One-to-One Association Using a Join Table
- Problem 
Another strategy to represent a one-to-one association uses a join table. As explained in Recipe 5.2, the foreign key in a table is null in some scenarios. To avoid storing the rows with null foreign keys, you can create a join table that holds the IDs of both dependent entities. How do you use a join table to establish a one-to-one association in Hibernate?
- Key Points
### 6-1. Mapping a Set
- Problem 
How do you map value types as collections of type java.util.Set?
- Key Points
### 6-2. Mapping a Bag
- Problem 
A bag is a collection of objects that can have duplicates. It doesn’t have any order. It is similar to an ArrayList, but it doesn’t retain its index. How do you map value types as collections of type bag? What is the difference between a bag without an ID and a bag with an ID? How do you map a value class in a bag with an associated ID?
- Key Points
### 6-3. Mapping a List
- Problem 
A list is a list of objects. It is an ordered collection. The user of a list has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list) and search for elements in the list. How do you map value types as collections of type list?
- Key Points
### 6-4. Mapping an Array
- Problem 
How do you map value types as arrays?
### 6-5. Mapping a Map
- Problem 
How do you map a set of key/value associations?
- Key Points
### 6-6. Sorting Collections
- Problem 
What are the possible ways to sort collections of objects or entities?
- Key Points
### 6-7. Using Lazy Initialization
- Problem 
What is lazy initialization? How does lazy initialization work with collections? How do you avoid the
LazyInitializationException?
- Key Points
### 7-1. Mapping a One-to-Many Association with a Foreign Key
- Problem 
How do you map objects using a one-to-many association with a foreign key? Can you establish this association from one direction only (a unidirectional association)? When an operation such as an update is executed on the parent object, users sometimes want the child object to be updated as well; this is called cascading in Hibernate. How do you use the cascading feature with a one-to-many association?
- Key Points
### 7-2 Mapping a One-to-Many Bidirectional Association Using a Foreign Key
- Problem 
How do you map objects using a one-to-many bidirectional association with a foreign key?
- Key Points
### 7-3 Mapping a One-to-Many Bidirectional Association
- Problem 
How do you map objects using a one-to-many association with a join table?
- Key Points
### 7-4. Mapping a Many-to-Many Association with a Join Table
- Problem 
How do you map objects using a many-to-many unidirectional association with a join table?
- Key Points

### 8-1. Using the Query Object
- Problem 
How do you create a Query object in Hibernate? How do you enable pagination? What are the various ways to bind parameters to a query?
- Key Points
### 8-2. Using the Select Clause
- Problem 
How and where do you use the select clause?
- Key Points
### 8-3. Joining
- Problem 
How do you create various types of joins in HQL and JPA QL?
- Key Points
### 8-4. Creating Report Queries
- Problem 
How do you create queries that group and aggregate data?
- Key Points
### 9-1. Using Criteria
- Problem 
How do you create a basic Criteria object and use it to load data from a database?
- Key Points

### 9-2. Using Restrictions
- Problem 
How do you filter data when using criteria? How do you apply restrictions to criteria?
- Key Points
### 9-3. Using Criteria in Associations
- Problem 
How do you express a join restriction using the Criteria API when there are associated objects? How do you use dynamic fetching?
- Key Points
### 9-4. Using Projections
- Problem  
What are projections, and how do you use them in the Criteria API?
- Key Points
### 9-5. Querying by Example
- Problem 
What is Query by Example (QBE) and how do you use it to retrieve data?
- Key Points
### 10-1.Working with Persistent Objects
- Problem 
How do you make a persistent object? How do you perform CRUD operations on it?
- Key Points
### 10-3. Persisting Detached Objects
- Problem 
How do you persist a detached object?
- Key Points
### 10-4. Using Data Filters
- Problem 
Suppose your bookshop has a lot of children and teenagers as users.6 You want to add a classification to the books so that you can limit access to certain books for underage readers. (You don’t want a child to be able to see a book meant for an adult reader.) How can you achieve this by using the data-filtering mechanism provided by Hibernate?
- Key Points
### 10-5. Using Interceptors
- Problem 
Suppose you want to save the date on any insert made into the BookShop database. For example, if a new publisher is inserted, you want to save the created date. The same is true for books: if a new book is entered into the database, you want to know when it was created by referring to the created date. How can you do this by using interceptors provided by Hibernate?
- Key Points
### 11-1. Performing Batch Inserts
- Problem 
How can you perform batch inserts within a single transaction?
- Key Points
### 11-2. Performing Batch Updates and Deletes
- Problem 
How do you perform batch updates and deletes?
- Key Points
### 11-3. Using Native SQL
- Problem 
Hibernate provides HQL, and it supports JPAQL criteria and Query by Example mechanisms to execute most queries. But what if you need to use database-specific features such as query hints or keywords? In such scenarios, you need to use Hibernate’s support for native SQL. How do you query using native SQL?
- Key Points

### 11-4. Using Named SQL Queries
- Problem 
How do you use named queries?
- Key Points
### 12-1. Using the First-Level Cache
- Problem 
What is the first-level cache, and how is it used in Hibernate?
- Key Points
### 12-2. Configuring the Second-Level Cache
- Problem 
What is the second-level cache, and how is it configured and used in Hibernate?
- Key Points
### 12-3. Caching Associations
- Problem 
Can associated objects be cached? How do you configure them?
- Key Points
### 12-4. Caching Collections
- Problem 
How do you cache collections?
- Key Points
### 12-5. Caching Queries
- Problem 
Can queries be cached? How is this achieved in Hibernate?
- Key Points
### 13-1. Using Programmatic Transactions in a Stand-alone Java Application
- Problem 
If you’re working on a stand-alone Java application, how do you achieve transaction demarcation?
- Key Points

### 13-2. Using Programmatic Transactions with JTA
- Problem 
Suppose that you’re using an application server that provides support to manage resources. Application servers such as WebLogic, WebSphere, and JBoss can provide connections from a connection pool
and manage transactions. How do you achieve programmatic transaction demarcation using the Java Transaction API (JTA)?5
- Key Points
### 13-4. Using Pessimistic Concurrency Control
- Problem 
How do you implement pessimistic concurrency control in your application to save the book entity?
- Key Points