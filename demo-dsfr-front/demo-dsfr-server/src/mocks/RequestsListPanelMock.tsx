import { fakerFR } from '@faker-js/faker';

// Start of user code d1177b453a3736dc602f6dc49b423f6b
// End of user code

export function getFakeTableData_ListRequestTable(nbRows = 10): string[]{
 // Start of user code 73e2c0c91f656f72845d18274c53bd12
 return Array.from({ length: nbRows }, () => [
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
  ] );
  
 // End of user code
}
