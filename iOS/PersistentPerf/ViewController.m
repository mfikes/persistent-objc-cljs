//
//  ViewController.m
//  PersistentPerf
//
//  Created by Mike Fikes on 11/12/14.
//
//

#import "ViewController.h"

#import "GBYLabel.h"
#import "GBYButton.h"

#import "AAPersistent.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)handleViewDidLoad {
    
    [[self getFunction:@"view-did-load!"]
     callWithArguments:@[self,
                         [GBYLabel wrap:self.objCTimeLabel],
                         [GBYLabel wrap:self.cljsTimeLabel],
                         [GBYButton wrap:self.runTestsButton]]];
}

- (NSString*)getNamespace
{
    return @"persistent-perf.view-controller";
}

-(void)runTests
{
    AAPersistentHashMap *v = [AAPersistentHashMap empty];
    v = [v withTransient:^(AATransientHashMap *transient) {
        for (int i = 0; i < 1000000; i += 1) {
            transient = [transient setObject:[NSString stringWithFormat:@"bar%d", i] forKey:[NSString stringWithFormat:@"foo%d", i]];
        }
        return transient;
    }];
}

-(double)currentTime
{
    return CACurrentMediaTime();
}

@end
