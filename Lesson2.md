#Plan
1. Design system and design app (tiny  url and library) 
2. Git
3. Gradle/maven
4. Hibernate
    - How do you generate an identifier for a database entity? 
    What are possible strategies? Increment( max id ), SEQUENCE(params, default hibernate sequence),
     hi/lo https://www.baeldung.com/hi-lo-algorithm-hibernate
     - pooled optimizer - https://vladmihalcea.com/hibernate-hidden-gem-the-pooled-lo-optimizer/ 
    - composite id

#Git
#Gradle
From gradle to maven - https://dzone.com/articles/how-to-convert-maven-to-gradle-and-vice-versa
#Maven
- BOM file https://howtodoinjava.com/maven/maven-bom-bill-of-materials-dependency/
#Hibernate: 
### Bidirectional @OneToMany  
- Bidirectional @OneToMany association from the performance perspective.
####Key points:
- always cascade from parent to child
-  use mappedBy on the parent
- use orphanRemoval on parent in order to remove children without references
- use helper methods on parent to keep both sides of the association in sync
- use lazy fetching on both side of the association
- as entities identifiers, use assigned identifiers (business key, natural key (@NaturalId)) and/or database-generated identifiers and override (on child-side) properly the equals() and hashCode() methods as here
- if toString() need to be overridden, then pay attention to involve only the basic attributes fetched when the entity is loaded from the database

### Bidirectional @OneToMany  
- Bidirectional @OneToMany association from the performance perspective.
#### Key points:
- always cascade from parent to child (from Author to Book) pls check other case - from Book  to Author
