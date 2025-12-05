import { fakerFR } from '@faker-js/faker';

// Start of user code 5adad5b103d11d932756b57cf2338a44
// End of user code

export function getFakeTableData_requestsInProgressTable(nbRows = 10): string[]{
 // Start of user code 0ad0d6675b28c54741b1c53ea80395f0
 const status = ['S', 'ET', 'EV', 'EA', 'C'];
 return Array.from({ length: nbRows }, () => [
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
   fakerFR.helpers.arrayElement(status),
  ] );
  
 // End of user code
}
export function getFakeTableData_requestFinalizedTable(nbRows = 10): string[]{
 // Start of user code 0e8d7bcfd08bccefa37a8093b30fae79
 return Array.from({ length: nbRows }, () => [
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
   fakerFR.string.alphanumeric(15),
  ] );
  
 // End of user code
}
