import { fakerFR } from '@faker-js/faker';

// Start of user code 8353939a891a06097144b42d0efd7e19
// End of user code

export function getFakeTableData_searchTable(nbRows = 10): string[]{
 // Start of user code b981354bd4b528c44f280464eef0b2ba
 return Array.from({ length: nbRows }, () => [
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
  ] );
  
 // End of user code
}
